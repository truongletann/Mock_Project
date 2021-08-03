let token = localStorage.getItem('USER_TOKEN');

function loadCate() {
    // LẤY TOKEN TỪ LOCALSTORAGE
    axios({
        url: 'http://localhost:8082/api/admin/category',
        method: 'get',
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
    .then(function(resp) {
        let listCate = resp.data;
        let content = '';
        let No = 1;
        for (let cate of listCate) {
            content += `
            <tr>
                <th>${No}</th>
                <td>${cate.title}</td>
                <td>
                    <a href="../ElearningLayoutAdmin/category-edit.html?id=${cate.category_id}" class="btn btn-sm btn-info btn-round py-1 font-weight-bold">Edit </a>
                    <a href="javascript:void(0)" class="btn btn-sm btn-danger btn-round py-1 font-weight-bold" onclick="remove(${cate.category_id})" >Delete</a>
                </td>
            </tr>
            `;
            No++;
        }
        document.getElementById('tBodyCate').innerHTML = content;
    })
    .catch(function(err){
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

loadCate();

function remove(id){
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
                url: `http://localhost:8082/api/admin/category/${id}`,
                method: 'delete',
                headers: {
                    "Authorization": `Bearer ${token}`
                }
            })
            .then(function(resp){
                swal("Successful !", "You clicked the button!", "success").then(function(resp){
                    window.location.href = '../ElearningLayoutAdmin/category-index.html';
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