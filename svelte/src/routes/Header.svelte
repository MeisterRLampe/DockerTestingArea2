<script>
	import { onMount } from 'svelte';
	import {page} from "$app/stores";

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

<header class="text-center">
	<nav class="navbar navbar-expand-lg   rounded ">
		<a class="navbar-brand" href="/">📕 Store Adventures</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse  " id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="http://localhost:5173/book">Bücher <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="http://localhost:5173/customer">Benutzer <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="http://localhost:5173/register">Register <span class="sr-only">(current)</span></a>
				</li>

			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
</header>

<style>
	header {
		background: #EDE6F2;
		display: flex;
		justify-content: space-between;
		align-items: center; /* Vertically center the content */
		padding: 1rem; /* Add some padding for spacing */

		border-radius: 15px;
	}

	nav{
		background: #EDE6F2;

	}
	ul {
		margin:0;
		padding:0;
		list-style-type:none;
		text-align:center;
	}

	li {
		margin-right: 1rem; /* Add spacing between navigation items */
		display:inline-block;
	}


	a {
		text-decoration: none;
		color: inherit;
	}

	@media (max-width: 991px) {
		.navbar-toggler {
			display: block;
		}
		.navbar-collapse {
			display: none;
		}
		.navbar-collapse.show {
			display: block;
		}
	}

</style>