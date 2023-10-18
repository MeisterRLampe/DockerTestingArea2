import { sveltekit } from '@sveltejs/kit/vite';
import { defineConfig } from 'vitest/config';

export default defineConfig({
	plugins: [sveltekit()],

	server:{
		proxy:{
			'/api': {
				target: "http://localhost:8080",
				rewrite: (path) => path.replace(/^\/api/, ''),
			}
			// rewrite: (path) => path.replace(/^\/api/, ''),
		}
	},

	test: {
		include: ['src/**/*.{test,spec}.{js,ts}'],

	}
});
