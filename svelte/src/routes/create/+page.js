
export const prerender = true;


export async function load({ fetch, params }) {
    const res = await fetch(`http://localhost:8080/api/`);
    const item = await res.json();


    return { item };
}

