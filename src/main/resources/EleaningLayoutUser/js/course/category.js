

function loadCategory() {
    axios({
        url: `http://localhost:8082/api/user/category`,
        method: 'GET',
    })
        .then(function (resp) {
            let listCategory = resp.data;
            // console.log(listCategory);
            let content = ``;
            for (let category of listCategory) {
                content += `
            <a class="dropdown-item" href="../EleaningLayoutUser/index.html?id=${category.category_id}">
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

