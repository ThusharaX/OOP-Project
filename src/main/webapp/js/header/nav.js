const btn = document.querySelector("button.toggle-menu");
        const menu = document.querySelector(".mobile-menu");

        // add event listeners
        btn.addEventListener("click", () => {
        menu.classList.toggle("hidden");
        });