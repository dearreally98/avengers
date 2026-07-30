// function checkForm(selector, message) {
//     const input = document.querySelector(selector);
//
//     if (input.value.trim() === "") {
//         input.value = "";
//         input.placeholder = `${message} 입력해 주세요.`;
//         input.focus();
//         return false;
//     }
//
//     return true;
// }
//
// function getDateFormat(dateValue) {
//     return [
//         dateValue.getFullYear(),
//         String(dateValue.getMonth() + 1).padStart(2, "0"),
//         String(dateValue.getDate()).padStart(2, "0")
//     ].join("-");
// }
//
// const formSubmit = (selector, method, action) => {
//     const form = document.getElementById(selector);
//     form.method = method;
//     form.action = action;
//     form.submit();
// }
//
// const locationProcess = (url) => {
//     location.href = url;
// }
//
// const chkFile = (fileInput) => {
//     if (fileInput.files.length === 0) {
//         return true;
//     }
//
//     const file = fileInput.files[0];
//     const ext = file.name.split(".").pop().toLowerCase();
//     const allowedExts = ["gif", "png", "jpg"];
//
//     if (!allowedExts.includes(ext)) {
//         alert("업로드 가능한 파일 확장자는 gif, png, jpg입니다.");
//         return false;
//     }
//
//     return true;
// };
//
//
//
