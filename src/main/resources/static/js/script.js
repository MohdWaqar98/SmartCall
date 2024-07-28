console.log("Script loaded")

let currentTheme = getTheme();


document.addEventListener('DOMContentLoaded', () => {
    changeTheme();
});

function changeTheme(){
    changePageTheme(currentTheme, currentTheme);
    const changeThemebutton=document.querySelector('#theme_change_button');
    const oldTheme=currentTheme;
    changeThemebutton.addEventListener("click", () => {
        console.log("change theme button click");
        const oldTheme= currentTheme;
        if(currentTheme == "dark"){
            currentTheme='light'
        }else{
            currentTheme='dark'
        }

        changePageTheme(currentTheme,oldTheme);
       
    });
}

function setTheme(theme){
    localStorage.setItem("theme", theme);
}

function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}


function changePageTheme(theme, oldTheme){
    setTheme(currentTheme);
    document.querySelector("html").classList.remove(oldTheme);
    document.querySelector("html").classList.add(theme);

}