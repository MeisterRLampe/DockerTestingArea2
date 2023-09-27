<script>
    import {onMount} from "svelte";

    let darkMode = false;

    function toggleDarkMode() {
        darkMode = !darkMode;
        document.documentElement.classList.toggle('dark-mode', darkMode);
        localStorage.setItem('darkMode', darkMode ? 'true' : 'false');
    }

    onMount(() => {
        const storedDarkMode = localStorage.getItem('darkMode');
        if (storedDarkMode === 'true') {
            darkMode = true;
            document.documentElement.classList.add('dark-mode');
        }
    });

</script>



<style>

     Stillabel {
		width: 50px;
		height: 20px;
		position: relative;
		display: block;
		background: #ebebeb;
		border-radius: 20px;
		box-shadow: inset 0px 5px 15px rgba(0, 0, 0, 0.4),
		inset 0px -5px 15px rgba(255, 255, 255, 0.4);
		cursor: pointer;
	}

	label:after {
		content: "";
		width: 18px;
		height: 18px;
		position: absolute;
		top: 1px;
		left: 1px;
		background: linear-gradient(180deg, #ffcc89, #d8860b);
		border-radius: 18px;
		box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
	}

	input {
		width: 0;
		height: 0;
		visibility: hidden;
	}

	input:checked + label {
		background: #242424;
	}

	input:checked + label:after {
		left: 49px;
		transform: translateX(-100%);
		background: linear-gradient(180deg, #777, #3a3a3a);
	}

	label,
	label:after {
		transition: 0.3s;
	}

	label:active:after {
		width: 26px;
	}

</style>
