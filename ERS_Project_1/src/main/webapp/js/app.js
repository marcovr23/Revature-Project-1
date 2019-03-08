function hide_sidebar(){
    let sidebar = document.getElementById('sidebar');
    if(sidebar.style.display === "none"){
        sidebar.style.display = "block";
    }else {
        console.log("Hello")
        sidebar.style.display = "none";
    }
}

document.getElementById('menu-button').addEventListener('click',hide_sidebar);