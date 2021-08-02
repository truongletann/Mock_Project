// LẤY TOKEN TỪ LOCALSTORAGE
// let token = localStorage.getItem('USER_TOKEN');

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
            data: cate
            // headers: {
            //     "Authorization": `Bearer ${token}`
            // }
        })
            .then(function (resp) {
                swal("Successfully !", "You clicked the button!", "success").then(function(resp){
                    window.location.href = '../ElearningLayoutAdmin/category-index.html';
                })
            })
            .catch(function (err) {
                console.log(err.response);
                swal("Unsuccessfully !", "You clicked the button!", "error");
            })
    
}

