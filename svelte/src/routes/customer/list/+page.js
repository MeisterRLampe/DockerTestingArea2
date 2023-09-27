export const prerender = true;

/** @type {import('../../../../.svelte-kit/types/src/routes').PageLoad} */
export async function load({ fetch, params }) {
    const res = await fetch(`http://localhost:8080/api/allcustomer`);
    const item = await res.json();


    return { item };
}