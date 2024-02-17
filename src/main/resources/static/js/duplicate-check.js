'use strict'

const memberIdEl = document.querySelector('#memberId');
const memberEmailEl = document.querySelector('#memberEmail');
const memberHpEl = document.querySelector('#memberHp');

/*아이디 중복 검사*/
memberIdEl.addEventListener('keyup',()=>{

    const MemberId = memberIdEl.value;
    if(MemberId.length < 5) return;

    //url과 http 메시지
    fetch('/members/duplication-check/id', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({memberId: MemberId}) //JS의 객체를 JSON화
    })
        .then(response => response.json())
        .then(count =>{
            count===1?alert('이미 존재하는 아이디입니다.'): alert('사용 가능한 아이디입니다.');
            }
        )
        .catch(console.log);
});