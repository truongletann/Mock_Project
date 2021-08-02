
function addRole() {
    // Lấy thông tin từ form
    let name = document.getElementById('name').value;
    let desc = document.getElementById('desc').value;

    let role = {
        "role_id": name,
        "role_name": desc
    }
    // Gọi api để thêm mới 
    axios({
        url: 'http://localhost:8082/api/admin/role',
        method: 'POST',
        data: role,
        // headers: {
        //     "Authorization":`Bearer ${token}`
        // }
    })
    .then(function (response) { // Xử lý response trả về
        console.log(response);
        swal("Success", "Add New Role SuccessFull", "success").then(response =>{
            window.location.href = '../ElearningLayoutAdmin/role-index.html';
        })
    })
    .catch(function (error) { // Xử lý error trả về
        console.log(error);
        swal("Unsuccessfully", "Add New Failure", "error");
    })
}