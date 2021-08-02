let UrlParam = new URLSearchParams(window.location.search);
let id = UrlParam.get("id");

function loadCourseDetail() {
    axios({
      url: `http://localhost:8082/api/user/userEnroll/${id}`,
      method: "get",
    })
      .then(function (resp) {
        let listUserEnroll = resp.data;
        let content = ``;
        for (let course of listUserEnroll) {
            console.log(course.courseDTO.image);
          content += `
          <div class="col-md-3">
                    <button href="#" class="my-course-item">
                        <img src="/static/img/${course.courseDTO.image}" alt="">
                        <h6 class="my-course-title"> ${course.courseDTO.title} </h6>
                        <div class="my-course-desc">
                           ${course.courseDTO.description}
                        </div>
                        <div class="my-course-author">
                            <h6>
                                <small>${course.courseDTO.full_name}</small>
                                <a class="btn btn-success" href="../EleaningLayoutUser/detail-lesson.html?id=${course.courseDTO.course_id}">Start course</a>
                            </h6>
                        </div>
                    </a>
                </div>
            `;
        }
        document.getElementById("courseUserEnroll").innerHTML = content;
      })
      .catch(function (err) {
        console.log(err);
      });
  }
  loadCourseDetail();