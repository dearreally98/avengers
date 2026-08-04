const reviewCommentNo = document.querySelector("#reviewNo");
const commentList = document.querySelector("#commentList");
const commentName= document.querySelector("#commentName");
const commentContent=document.querySelector("#commentContent");
const commentInsertBtn = document.querySelector("#commentInsertBtn");
const commentCancelBtn= document.querySelector("#commentCancelBtn");
const commentPaging= document.querySelector("#commentPaging");

let updateCommentNo = null;
let currentPage = 0;

window.commentLoad = function(page = 0) {
    currentPage = page;

    fetch(`/review/${reviewCommentNo.value}/comments?page=${page}&size=10`)
        .then(response => response.json())
        .then(data => {

            console.log(data);

            if(data.content.length === 0){
                commentList.innerHTML = "등록된 댓글이 없습니다.";
            } else {

                let commentAdd = "";

                data.content.forEach(comment => {
                    commentAdd += `
                     <div class="border p-3 mb-2">
                        <div class="d-flex justify-content-between">
                            <strong>${comment.nickname}</strong>
                            
                            <div>
                                <button type="button"
                                        class="btn btn-sm btn-outline-success"
                                        data-id="${comment.id}"
                                        data-name="${comment.nickname}"
                                        data-body="${comment.commentBody}">
                                     수정
                                </button>
                                
                                <button type="button"
                                        class="btn btn-sm btn-outline-danger ms-1"
                                        data-id="${comment.id}">
                                     삭제
                                </button>
                            </div>
                        </div>
                        
                        <div class="mt-2">
                             ${comment.commentBody}
                        </div>
                    </div>
                `;
                });

                commentList.innerHTML = commentAdd;
            }

            let pagingAdd= "";

            if (data.totalPages > 1){
                if (data.first === false){
                    pagingAdd += `
                        <button class="btn btn-outline-secondary me-1"
                                onclick="commentLoad(${data.number - 1})">
                            이전
                        </button>`;
                }
                for (let i=0; i<data.totalPages; i++){
                    pagingAdd += `
                        <button class="btn ${data.number === i ? 'btn-primary' : 'btn-outline-primary'} me-1"
                                onclick="commentLoad(${i})">
                            ${i+1}
                        </button>`;
                }

                if (data.last === false){
                    pagingAdd += `
                        <button class="btn btn-outline-secondary"
                                onclick="commentLoad(${data.number + 1})">
                            다음
                        </button>`;
                }
            }
            commentPaging.innerHTML=pagingAdd;

        })
        .catch(error => {
            alert("댓글을 불러오는 중 오류가 발생했습니다.")
            console.error("error");
        });
};

commentInsertBtn.addEventListener("click", () => {
    const nickname = commentName.value.trim();
    const commentBody = commentContent.value.trim();

    if (nickname === ""){
        alert("닉네임을 입력해 주세요.");
        commentName.focus();
        return;
    }

    if (commentBody === ""){
        alert("댓글 내용을 입력해 주세요.");
        commentContent.focus();
        return;
    }

    const commentData = {
        nickname: nickname,
        commentBody: commentBody
    };

    let url = `/review/${reviewCommentNo.value}/comments`;
    let method = "POST";

    if (updateCommentNo !== null){
        url = `/review/comments/${updateCommentNo}`;
        method = "PUT";
    }

    fetch(url, {
        method: method,
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(commentData)
    })
        .then(response => {
            if (!response.ok){
                throw new Error("댓글 등록 실패")
            }
            return response.json();
        })
        .then(data => {

            if (updateCommentNo !== null){
                alert("수정이 완료되었습니다.");
            } else {
                alert("등록이 완료되었습니다.");
            }

            commentName.value = "";
            commentContent.value = "";

            updateCommentNo = null;
            commentName.readOnly = false;
            commentInsertBtn.textContent= "댓글 등록";

            commentLoad(currentPage);
        })
        .catch(error => {
            console.error(error);
            alert("댓글 등록 중 오류가 발생했습니다.");
        });
});

commentCancelBtn.addEventListener("click", () => {
  commentName.value = "";
  commentContent.value = "";

  updateCommentNo = null;
  commentName.readOnly = false;
  commentInsertBtn.textContent = "댓글 등록";
});

commentList.addEventListener("click", (event) => {
    if (event.target.classList.contains("btn-outline-success")){
        updateCommentNo=event.target.dataset.id;
        const nickname=event.target.dataset.name;
        const commentBody=event.target.dataset.body;

        commentName.value=nickname;
        commentContent.value=commentBody;
        commentName.readOnly = true;
        commentInsertBtn.textContent = "댓글 수정";
        commentContent.focus();
    }
});

commentList.addEventListener("click", (event) => {
    if (event.target.classList.contains("btn-outline-danger")){
        const commentNo = event.target.dataset.id;

        if (!confirm("댓글을 삭제하시겠습니까?")){
            return;
        }

        fetch(`/review/comments/${commentNo}`, {
            method: "DELETE"
        })
            .then(response => {
                if (!response.ok){
                    throw new Error("댓글 삭제 실패");
                }

                alert("댓글이 삭제되었습니다.");
                commentLoad(currentPage);
            })
            .catch(error => {
                console.error(error);
                alert("댓글 삭제 중 오류가 발생했습니다.");
            });
    }
});

commentLoad();