const nombre = sessionStorage.getItem("noombreUsuario");
    if(nombre){
        document.getElementById("mensaje").textContent = `Bienvenid@, ${nombre}`;
    }
    function cerrarSesion(){
        sessionStorage.clear();
        window.location.href = "/login.html";
    }