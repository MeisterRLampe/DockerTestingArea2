import adapter from '@sveltejs/adapter-static';
import { vitePreprocess } from '@sveltejs/kit/vite';

export default {
	kit: {
		adapter: adapter({
			fallback: '200.html', // may differ from host to host

			preprocess: vitePreprocess()
		}),
		csrf: {
			checkOrigin: false
		},


	}
};



