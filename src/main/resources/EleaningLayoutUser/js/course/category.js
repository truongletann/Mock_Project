function loadCategory() {
    axios({
        url: `http://localhost:8082/api/admin/category`,
        method: 'GET',
    })
        .then(function (resp) {
            let listCategory = resp.data;
            // console.log(listCategory);
            let content = ``;
            for (let category of listCategory) {
                content += `
                <a class="dropdown-item" href="#">
                <span>${category.title}</span>
            </a>
            `
            }
            document.getElementById('list-category').innerHTML = content;
        })
        .catch(function (err) {
            console.log(err)
        })
}
loadCategory();


// function loadTopCategory() {
//     axios({
//         url: `http://localhost:8082/api/admin/category`,
//         method: 'GET',
//     })
//         .then(function (resp) {
//             let listCategory = resp.data;
//             console.log(listCategory);
//             let content = ``;
//             for (let category of listCategory) {
//                 content += `
//                 <div class="col-md-3">
//                 <a class="category">
//                     <i class="fa fa-laptop"></i>
//                     <span>${category.title}</span>
//                 </a>
//             </div>
//             `
//             }
//             document.getElementById('top-category').innerHTML = content;
//         })
//         .catch(function (err) {
//             console.log(err)
//         })
// }
// loadTopCategory();