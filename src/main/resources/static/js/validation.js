'use strict'

const memberForValidation = document.querySelector('#member');
const memberPw = document.querySelector('#memberPw');
const memberPw2 = document.querySelector('#memberPw2');
const password2Error = document.querySelector('#memberPw2Error')

/*서버 유효성 검사 실패 후 input 밑에 있는 에러 메시지 제거*/
memberForValidation.addEventListener('click',event =>{
    let target = event.target;

    //클릭된 요소가 input인지 확인
    if(target.tagName !== 'INPUT') return;

    //클릭된 input에서 가장 가까운 에러 메시지 컨테이너 찾기
    const serverErrorMessage = target.nextElementSibling.querySelector('.label__error');
    serverErrorMessage.classList.add('hide');
})


/*비밀번호와 비밀번호 확인이 불일치하는 경우 */
memberPw2.addEventListener('keyup',()=>{
    const password = memberPw.value;
    const password2 = memberPw2.value;

    if(password2.length >= 8 && password !== password2){
        password2Error.classList.remove('hide') ;
    }
    else{
        password2Error.classList.add('hide');
    }

})
