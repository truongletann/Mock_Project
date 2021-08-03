let token = localStorage.getItem('USER_TOKEN');

function loadCourseData() {
    // LẤY TOKEN TỪ LOCALSTORAGE
    axios({
        url: 'http://localhost:8082/api/admin/course',
        method: 'get',
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
    .then(function(resp) {
        let listCourse = resp.data;
        let content = '';
        for (let course of listCourse) {
            content += `
            <tr>
                <th><img src='/static/img/${course.image}' height="50" class="p-1 border" /></th>
                <td>${course.title}</td>
                <td>${course.description}</td>
                <td>${course.category_name}</td>
                <td class="text-danger font-weight-bold">${course.full_name}</td>
                <td class="text-danger font-weight-bold">${course.last_update}</td>
                <td>
                    <a href="../ElearningLayoutAdmin/course-edit.html?id=${course.course_id}"class="btn btn-sm btn-info btn-round py-1 font-weight-bold">Edit  </a>
                    <a href="javascript:void(0)"class="btn btn-sm btn-danger btn-round py-1 font-weight-bold" onclick="remove(${course.course_id})" >Delete </a>
                </td>
            </tr>
            `;
        }
        document.getElementById('tBodyCourse').innerHTML = content;
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

loadCourseData();

function remove(id){
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this course!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((willDelete) => {
        if (willDelete) {
            axios({
                url: `http://localhost:8082/api/admin/course/${id}`,
                method: 'delete',
                // headers: {
                //     "Authorization": `Bearer ${token}`
                // }
            })
            .then(function(resp){
                swal("Successfull !", "You clicked the button!", "success").then(function(resp){
                    window.location.href = '../ElearningLayoutAdmin/course-list.html';
                })
            })
            .catch(function(err){
                console.log(err)
                swal("Unsuccessfull !", "You clicked the button!", "error")
            })
            
          swal("Poof! Your course has been deleted!", {
            icon: "success",
          });
        } else {
          swal("Your imaginary file is safe!");
        }
      });

}