let UrlParam = new URLSearchParams(window.location.search);
let id = UrlParam.get("id");

let listUserEnroll;
function loadLessonDetail() {
    axios({
      url: `http://localhost:8082/api/user/course-detail/by-course/${id}`,
      method: "get",
    })
      .then(function (resp) {
        listUserEnroll = resp.data;
        let content = ``;
        let no =0;
        for (let course of listUserEnroll) {
            
          content += `

          <li>
        <a class="video-btn" type="button"  onclick="changeUrlVideo(${no})">  
            <span> <i class="fa fa-play-circle mr-1"></i>
                ${course.title}
            </span>
            
        </a>
    </li>

            `;
            no++;
        }
        content += `
        <li>
              <a class="btn btn-outline-info w-100" style="text-align: center;" href="../EleaningLayoutUser/quiz.html?id=${id}&userId=1">QUIZ</a>
        </li>
        `;
        document.getElementById("list-content").innerHTML = content;
        document.getElementById("showVideo").innerHTML = `
        <iframe width="992" height="500" src="https://www.youtube.com/embed/${listUserEnroll[0].url}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        `;
      })
      .catch(function (err) {
        console.log(err);
      });
  }
  loadLessonDetail();

  function changeUrlVideo(numberA){
    let aa= listUserEnroll[numberA].url;
    document.getElementById("showVideo").innerHTML = `
        <iframe width="992" height="500" src="https://www.youtube.com/embed/${aa}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        `;
  }