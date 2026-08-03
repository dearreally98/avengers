const searchForm = document.querySelector("#searchForm");
const searchType = document.querySelector('#searchType');

const pageInput = document.querySelector("#page");
const pageLinks = document.querySelectorAll(".page-link");

searchForm.addEventListener("submit", function (e) {
    e.preventDefault();

    if(searchType.value === "") {
        alert("검색 조건을 선택해 주세요.");
        searchType.focus();
        return;
    }
    if(!chkData("#keyword", "검색어를")) {
        return;
    }
    pageInput.value = 1;
    searchForm.submit();
});

pageLinks.forEach(function (pageLink) {
    pageLink.addEventListener("click", function (e) {
        e.preventDefault();

        const page = pageLink.dataset.page;
        pageInput.value = page;
        searchForm.submit();
    });
});