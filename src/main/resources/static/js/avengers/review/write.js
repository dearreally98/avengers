const insertForm= document.querySelector("#insertForm");
const inputName= document.querySelector("#inputName");
const inputTitle= document.querySelector("#inputTitle");
const inputContent= document.querySelector("#inputContent");

const fileInput = document.querySelector("#reviewFile");
const fileName= document.querySelector("#fileName");

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

fileInput.addEventListener("change", () => {
    if(!chkFile(this)){
        this.value= "";
        fileName.textContent= "";
        return;
    }

    fileName.textContent= this.files.length > 0 ? this.files[0].name : "";
});

fileInput.addEventListener("cancel", () => {
    this.value= "";
    fileName.textContent= "";
});