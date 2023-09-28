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

<header>
	<nav class="w-full bg-blue-700 border-r-15">

		<ul>
			<li aria-current={$page.url.pathname === '/' ? 'page' : undefined}>
				<a href="/">Home</a>
			</li>
			<li aria-current={$page.url.pathname === '/customer' ? 'page' : undefined}>
				<a href="/customer">Customer</a>
			</li>
			<li aria-current={$page.url.pathname.startsWith('/book') ? 'page' : undefined}>
				<a href="/book">Books</a>
			</li>
			<li aria-current={$page.url.pathname === '/register' ? 'page' : undefined}>
				<a href="/register">Register</a>
			</li>
			<li>
				<input type="checkbox" id="darkmode-toggle" on:change={toggleDarkMode} bind:checked={darkMode} />
				<label for="darkmode-toggle">Dark Mode</label>
			</li>
		</ul>
	</nav>
</header>

<style>
	header {
		display: flex;
		justify-content: space-between;
		align-items: center; /* Vertically center the content */
		padding: 1rem; /* Add some padding for spacing */
		background-color: var(--background); /* Set the background color */
		color: var(--color-text); /* Set the text color */
	}

	nav {
		display: flex;
		align-items: center;
	}

	ul {
		list-style: none;
		padding: 0;
		margin: 0;
		display: flex;
	}

	li {
		margin-right: 1rem; /* Add spacing between navigation items */
	}

	a {
		text-decoration: none;
		color: inherit;
	}

	/* Add your dark mode styles here */
	.dark-mode {
		background-color: var(--background-dark);
		color: var(--text-dark);
	}
</style>