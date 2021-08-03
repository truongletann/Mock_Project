let token = localStorage.getItem('USER_TOKEN');

function addRole() {
    // Lấy thông tin từ form
    let desc = document.getElementById('desc').value;

    let role = {
        "role_name": desc
    }
    // Gọi api để thêm mới 
    axios({
        url: 'http://localhost:8082/api/admin/role',
        method: 'POST',
        data: role,
        headers: {
            "Authorization":`Bearer ${token}`
        }
    })
    .then(function (response) { // Xử lý response trả về
        console.log(response);
        swal("Success", "Add New Role SuccessFull", "success").then(response =>{
            window.location.href = '../ElearningLayoutAdmin/role-index.html';
        })
    })
    .catch(function (error) { // Xử lý error trả về
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
        }else{
            swal("Unsuccessfully", "Add New Failure", "error");
        }

    })
}