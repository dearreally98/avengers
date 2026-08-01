const insertForm= document.querySelector("#insertForm");
const inputName= document.querySelector("#inputName");
const inputTitle= document.querySelector("#inputTitle");
const inputContent= document.querySelector("#inputContent");

insertForm.addEventListener("submit", (event) => {
    event.preventDefault();

    let check= true;

    inputName.classList.remove("is-invalid");
    inputTitle.classList.remove("is-invalid");
    inputContent.classList.remove("is-invalid");

    if (inputName.value.trim() === ""){
        inputName.classList.add("is-invalid");
        check = false;
    }
    if (inputTitle.value.trim() === ""){
        inputTitle.classList.add("is-invalid");
        check = false;
    }
    if (inputContent.value.trim() === ""){
        inputContent.classList.add("is-invalid");
        check = false;
    }
    if (check){
        insertForm.submit();
    }
});