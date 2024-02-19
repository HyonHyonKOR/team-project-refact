'use strict'

const memberIdEl = document.querySelector('#memberId');
const duplicatedId = document.querySelector('#duplicatedId');
const notDuplicatedId = document.querySelector('#notDuplicatedId')

const memberHpEl = document.querySelector('#memberHp');
const duplicatedHp = document.querySelector('#duplicatedHp');
const notDuplicatedHp = document.querySelector('#notDuplicatedHp')

const memberEmailEl = document.querySelector('#memberEmail');
const duplicatedEmail = document.querySelector('#duplicatedEmail');
const notDuplicatedEmail = document.querySelector('#notDuplicatedEmail')


/*아이디 중복 검사 이벤트*/
memberIdEl.addEventListener('keyup',()=>{
    const memberId = memberIdEl.value;
    notDuplicatedId.classList.add('hide');
    duplicatedId.classList.add('hide');
    if(memberId.length < 5) return;
    debouncedCheckDuplicatedId(memberId);
});

/*핸드폰 중복 검사 이벤트*/
memberHpEl.addEventListener('keyup',()=>{
    const memberHp = memberHpEl.value;
    notDuplicatedHp.classList.add('hide');
    duplicatedHp.classList.add('hide')
    if(memberHp.length < 11) return;
    debouncedCheckDuplicatedHp(memberHp);
});


/*이메일 중복 검사 이벤트*/
memberEmailEl.addEventListener('keyup',()=>{
    const memberEmail = memberEmailEl.value;
    notDuplicatedEmail.classList.add('hide');
    duplicatedEmail.classList.add('hide');
    if(memberEmail.length < 7) return;
    debouncedCheckDuplicatedEmail(memberEmail);
});

/*아이디 비동기 처리 및 중복 검사 */
function checkDuplicatedId(memberId){
    //url과 http 메시지
    fetch('/members/duplication-check/id', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({memberId}) //JS의 객체를 JSON화 {memberId:memberId} -> {memberId}
    })
        .then(response => response.json())
        .then(count =>{
                if(count===1) {
                    duplicatedId.classList.remove('hide');
                    notDuplicatedId.classList.add('hide')
                }
                else{
                    notDuplicatedId.classList.remove('hide');
                    duplicatedId.classList.add('hide')
                }

            }
        )
        .catch(console.log);
}

/*휴대폰 번호 비동기 처리 및 중복검사*/
function checkDuplicatedHp(memberHp){
    //url과 http 메시지
    fetch('/members/duplication-check/hp', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({memberHp}) //JS의 객체를 JSON화 {memberHp:memberHp} -> {memberHp}
    })
        .then(response => response.json())
        .then(count => {
            if(count===1) {
                duplicatedHp.classList.remove('hide');
                notDuplicatedHp.classList.add('hide')
            }
            else{
                notDuplicatedHp.classList.remove('hide');
                duplicatedHp.classList.add('hide')
            }
            }
        )
        .catch(console.log);
}

/*이메일 비동기 처리 및 중복검사 함수*/
function checkDuplicatedEmail(memberEmail){
    //url과 http 메시지
    fetch('/members/duplication-check/email', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({memberEmail}) //JS의 객체를 JSON화 {memberEmail:memberEmail} -> {memberEmail}
    })
        .then(response => response.json())
        .then(count =>{
            if(count===1) {
                duplicatedEmail.classList.remove('hide');
                notDuplicatedEmail.classList.add('hide')
            }
            else{
                notDuplicatedEmail.classList.remove('hide');
                duplicatedEmail.classList.add('hide')
            }
            }
        )
        .catch(console.log);
}


/*디바운스로 ajax 절약 */
const debouncedCheckDuplicatedId = _.debounce(checkDuplicatedId, 300);
const debouncedCheckDuplicatedHp = _.debounce(checkDuplicatedHp, 300);
const debouncedCheckDuplicatedEmail = _.debounce(checkDuplicatedEmail, 300);
