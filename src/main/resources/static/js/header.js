'use strict'

/*헤더 쇼핑몰 버튼 검색*/
const headerShopMenuLink = document.querySelector('#nav-shop__link');
const tablet = window.matchMedia('(min-width: 769px)').matches;
headerShopMenuLink.addEventListener('click',(event)=>{
    if(window.matchMedia('(min-width: 769px)').matches){
        return;
    }
    event.preventDefault();
    const navShopMenus = document.querySelector('.nav-shop__menus');
    navShopMenus.classList.toggle('active');
})


/*헤더 검색 버튼 토글*/
const headerItemSearchLink = document.querySelector('.header__nav-search');

headerItemSearchLink.addEventListener('click',()=>{
    const headerItemSearchContainer = document.querySelector('.nav-search__menus');
    headerItemSearchContainer.classList.toggle('active');
});


/*헤더 반응형 토글*/
const headerToggle = document.querySelector('.header__toggle');

headerToggle.addEventListener('click',()=>{
    const headerNav = document.querySelector('.header__nav');
    headerNav.classList.toggle('active');
});




/*로그인 헤더 로그아웃*/

const memberLogoutLink = document.querySelector('.member__logout');

memberLogoutLink.addEventListener('click',()=>{
    const memberLogoutForm = document.createElement('form');
    memberLogoutForm.setAttribute('method','post');
    memberLogoutForm.setAttribute('action','/members/logout');
    document.body.appendChild(memberLogoutForm);
    memberLogoutForm.submit();
})
