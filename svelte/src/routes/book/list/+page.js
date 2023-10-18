export const prerender = true;
import {token} from "../../../stores.js";





/** @type {import('../../../../.svelte-kit/types/src/routes').PageLoad} */
export async function load({ fetch, params }) {
    try {
        const res = await fetch(`/api/api/allbooks`,{
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
            },
            credentials: 'include',
            mode: 'cors',
        });
        const item = await res.text();
        return { item };
    } catch (e) {
        console.log(e)
        return {
            ok:"ok"
        }
    }
}

