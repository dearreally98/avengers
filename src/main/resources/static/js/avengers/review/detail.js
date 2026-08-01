const updateBtn= document.querySelector("#updateBtn");
const deleteBtn= document.querySelector("#deleteBtn");
const reviewNo= document.querySelector("#reviewNo");

updateBtn.addEventListener("click", () => {
    const no= reviewNo.value;
    locationProcess(`/review/${no}/update`);
});

deleteBtn.addEventListener("click", () => {
    if (!confirm("게시글을 삭제하시겠습니까?")){
        return;
    }
    const no=reviewNo.value;
    formSubmit("formData", "post", `/review/${no}/delete`);
})