const updateBtn= document.querySelector("#updateBtn");
const passwordBox= document.querySelector("#passwordBox");
const passwordCheckBtn= document.querySelector("#passwordCheckBtn");
const passwordCancelBtn= document.querySelector("#passwordCancelBtn");
const reviewPassword= document.querySelector("#reviewPassword");
const deleteBtn= document.querySelector("#deleteBtn");
const reviewNo= document.querySelector("#reviewNo");

let processType= "";

updateBtn.addEventListener("click", () => {
    processType= "update";
    passwordBox.classList.remove("invisible");
});

deleteBtn.addEventListener("click", () => {
    processType= "delete";
    passwordBox.classList.remove("invisible");
});

passwordCheckBtn.addEventListener("click", () => {

    const no= reviewNo.value;
    const password= reviewPassword.value;

    fetch(`/review/${no}/password-check?reviewPassword=${password}`, {
        method: "POST"
    })
        .then(response => response.json())
        .then(result => {

            if (result){
                if (processType === "update"){
                    locationProcess(`/review/${no}/update`);
                } else if (processType === "delete"){
                    if (!confirm("게시글을 삭제하시겠습니까?")){
                        formSubmit("formData", "post", `/review/${no}/delete`);
                    }
                }
            } else {
                alert("비밀번호가 틀렸습니다.");
                reviewPassword.value="";
            }
        });
    });