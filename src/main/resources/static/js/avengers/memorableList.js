// 수정 버튼 클릭
function editCard(button) {

    // 수정 버튼이 속해 있는 카드 찾기
    const card = button.closest('.card');

    // 일반 카드 찾기
    const normalCard = card.querySelector('.normal-card');

    // 수정 카드 찾기
    const editCard = card.querySelector('.edit-card');


    // 일반 카드 숨기기
    normalCard.style.display = 'none';

    // 수정 카드 보여주기
    editCard.style.display = 'block';
}


// 취소 버튼 클릭
function cancelEdit(button) {

    // 취소 버튼이 속해 있는 카드 찾기
    const card = button.closest('.card');

    // 일반 카드 찾기
    const normalCard = card.querySelector('.normal-card');

    // 수정 카드 찾기
    const editCard = card.querySelector('.edit-card');


    // 수정 카드 숨기기
    editCard.style.display = 'none';

    // 일반 카드 보여주기
    normalCard.style.display = 'block';
}