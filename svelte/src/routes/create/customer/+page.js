export const prerender = true;

/** @type {import('./$types').PageLoad} */
export async function load({ fetch, params }) {
    const res = await fetch(`http://localhost:8080/api/customer/create`);
    const item = await res.json();


    return { item };
}

