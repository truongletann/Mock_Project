let token = localStorage.getItem('USER_TOKEN');

function loadRoleData() {
    axios({
        url: 'http://localhost:8082/api/admin/role',
        method: 'get',
        headers: {
            "Authorization":`Bearer ${token}`
        }
    })
    .then(function(resp) {
        let listRole = resp.data;
        console.log(listRole);
        let content = '';
        for (let role of listRole) {
            content += `
            <tr>
            <th>${role.role_id}</th>
            <td>${role.role_name}</td>
            <td>
                <a href="../ElearningLayoutAdmin/role-edit.html?id=${role.role_id}"
                    class="btn btn-sm btn-info btn-round py-1 font-weight-bold">Edit</a>
                <a href="javascript:void(0)"
                    class="btn btn-sm btn-danger btn-round py-1 font-weight-bold" onclick="remove(${role.role_id})">Delete</a>
            </td>
        </tr>
            `;
        }
        document.getElementById('tbodyRole').innerHTML = content;
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

loadRoleData();
function remove(id){
    // var idDelete= id;
    // console.log('ABC');
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
                url: `http://localhost:8082/api/admin/role/${id}`,
                method: 'delete',
                headers: {
                    "Authorization":`Bearer ${token}`
                }
            })
            .then(function(resp){
                swal("Successfull !", "You clicked the button!", "success").then(function(resp){
                    window.location.href = '../ElearningLayoutAdmin/role-index.html';
                })
            })
            .catch(function(err){
                console.log(err)
                swal("Unsuccessfull !", "You clicked the button!", "error")
            })
            
          swal("Poof! Your imaginary file has been deleted!", {
            icon: "success",
          });
        } else {
          swal("Your imaginary file is safe!");
        }
      });

}