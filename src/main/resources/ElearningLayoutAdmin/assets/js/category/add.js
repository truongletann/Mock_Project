// LẤY TOKEN TỪ LOCALSTORAGE
let token = localStorage.getItem('USER_TOKEN');

function save() {

    let title = document.getElementById('title').value;
        // TẠO ĐỐI TƯỢNG USER
        let cate = {
            "title": title
        }

        // GỌI API THÊM MỚI
        axios({
            url: 'http://localhost:8082/api/admin/category',
            method: 'POST',
            data: cate,
            headers: {
                "Authorization": `Bearer ${token}`
            }
        })
            .then(function (resp) {
                swal("Successfully !", "You clicked the button!", "success").then(function(resp){
                    window.location.href = '../ElearningLayoutAdmin/category-index.html';
                })
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
                }else{
                    swal("Unsuccessfully !", "You clicked the button!", "error");
                }

            })
    
}

