const reviewCommentNo = document.querySelector("#reviewNo");
const commentList = document.querySelector("#commentList");
const commentName= document.querySelector("#commentName");
const commentContent=document.querySelector("#commentContent");
const commentInsertBtn = document.querySelector("#commentInsertBtn");
const commentCancelBtn= document.querySelector("#commentCancelBtn");

const commentLoad = () => {
    fetch(`/review/${reviewCommentNo.value}/comments`)
        .then(response => response.json())
        .then(data => {

            if(data.length === 0){
                commentList.innerHTML = "등록된 댓글이 없습니다.";
                return;
            }

            let commentAdd = "";

            data.forEach(comment => {
                commentAdd += `
                     <div class="border p-3 mb-2">
                        <div class="d-flex justify-content-between">
                            <strong>${comment.nickname}</strong>
                            
                            <div>
                                <button type="button"
                                        class="btn btn-sm btn-outline-success">
                                     수정
                                </button>
                                
                                <button type="button"
                                        class="btn btn-sm btn-outline-danger ms-1">
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
        })
        .catch(error => {
            alert("댓글을 불러오는 중 오류가 발생했습니다.")
            console.error("error");
        });
};

commentLoad();