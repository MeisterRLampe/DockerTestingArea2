
export const prerender = true;

export async function load({ fetch, params }) {
    const res = await fetch(`http://localhost:8080/api/book/${params.book}`);
    const iterate = await res.text();


    return { iterate };
}