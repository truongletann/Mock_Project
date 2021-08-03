
let token = localStorage.getItem('USER_TOKEN');

let url_str = window.location.href;
let url = new URL(url_str);
let id = url.searchParams.get('id');


function loadCourseDetail() {
    axios({
        url: `http://localhost:8082/api/admin/course-detail/by-course/${id}`,
        method: 'get',
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
        .then(function (resp) {
            let listCourseDetail = resp.data;
            let content = '';
            let No = 1;
            for (let courseDetail of listCourseDetail) {
                content += `
                <tr>
                    <th class="text-danger font-weight-bold">${No}</th>
                    <td>${courseDetail.title}</td>
                    <td>
                    <iframe width="350" height="150" src="https://www.youtube.com/embed/${courseDetail.url}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </td>
                    <td>
                        <a href="../ElearningLayoutAdmin/detail-course-edit.html?id=${courseDetail.course_detail_id}" class="btn btn-sm btn-info btn-round py-1 font-weight-bold">Edit</a>
                        <a href="javascript:void(0)" class="btn btn-sm btn-danger btn-round py-1 font-weight-bold" onclick="remove(${courseDetail.course_detail_id})">Xóa</a>
                    </td>
                </tr>                                                   
            `;
            No++;
            }
            document.getElementById('tbodyCourseDetail').innerHTML = content;
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

loadCourseDetail();


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
                url: `http://localhost:8082/api/admin/course-detail/${idRemove}`,
                method: 'delete',
                headers: {
                    "Authorization": `Bearer ${token}`
                }
            })
            .then(function(resp){
                swal("Successfull !", "You clicked the button!", "success").then(function(resp){
                    window.location.href = '../ElearningLayoutAdmin/detail-course.html?id='+id;
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

function addNew(){
    window.location.href = "../ElearningLayoutAdmin/detail-course-add.html?id=" + id;
}