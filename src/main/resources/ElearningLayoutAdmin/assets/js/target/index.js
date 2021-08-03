let token = localStorage.getItem('USER_TOKEN');

let url_str = window.location.href;
let url = new URL(url_str);
let id = url.searchParams.get('id');




function loadTarget() {
    axios({
        url: `http://localhost:8082/api/admin/target/by-course/${id}`,
        method: 'get',
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
        .then(function (resp) {
            let listTarget = resp.data;
            // console.log(listTarget);
            let content = '';
            let No = 1;
            for (let target of listTarget) {
                content += `
            <tr>
                <td>${No}</td>
                <td>${target.target_title}</td>
                <td>
                    <a href="../ElearningLayoutAdmin/target-edit.html?id=${target.target_id}" class="btn btn-sm btn-info btn-round py-1 font-weight-bold">Edit</a>
                <a href="javascript:void(0)" class="btn btn-sm btn-danger btn-round py-1 font-weight-bold" onclick="remove(${target.target_id})">Delete</a>
             </td>
             </tr>

            `;
            No++;
            }
            document.getElementById('tbodyTarget').innerHTML = content;
        })
        .catch(function (err) {
            let data = err.response.data;
            if(data.status == 401){
                document.location.href = "./login.html";
            }
            else if(data.status == 403){
                if(token != null){
                    // XÓA TOKEN KHỎI LOCALSTORAGE
                    localStorage.removeItem('USER_TOKEN');
                    document.location.href = "./login.html";
                }
            }
        })
}

loadTarget();


function remove(idRemove){
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this imaginary file!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((willDelete) => {
        if (willDelete) {
            axios({
                url: `http://localhost:8082/api/admin/target/${idRemove}`,
                method: 'delete',
                headers: {
                    "Authorization": `Bearer ${token}`
                }
              
            })
            .then(function(resp){
                swal("Successful !", "You clicked the button!", "success").then(function(resp){
                    window.location.href = '../ElearningLayoutAdmin/target-list.html?id='+id;
                })
            })
            .catch(function(err){
                console.log(err)
                swal("Unsuccessful !", "You clicked the button!", "error")
            })
            
          swal("Poof! Your imaginary file has been deleted!", {
            icon: "success",
          });
        } else {
          swal("Your imaginary file is safe!");
        }
      });

}

function addNew(){
    window.location.href = "../ElearningLayoutAdmin/target-add.html?id=" + id;
}