document.addEventListener("DOMContentLoaded", () => {
    // DOMContentLoaded => HTML 문서가 전부 로딩된 순간을 알려주는 이벤트
    // HTML 태그들 다 만들어지면 그때 자바스크립트를 실행해 달라는 의미

    const searchForm = document.querySelector("#searchForm");
    const searchType= document.querySelector("#searchType");
    const keyword= document.querySelector("#keyword");

    searchForm.addEventListener("submit", (event) => {
        if (searchType.value === ""){
            event.preventDefault();
            alert("검색 항목을 선택해 주세요.");
            searchType.focus();
            return;
        }

        if (keyword.value.trim() === "") {
            event.preventDefault();
            alert("검색어를 입력해 주세요.");
            keyword.focus();
            return;
        }
    });
});