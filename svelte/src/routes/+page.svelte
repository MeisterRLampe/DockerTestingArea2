<script xmlns="http://www.w3.org/1999/html">
    import {onMount} from "svelte";

    export let data;
    import totoro from "../assets/totorofirepit.png"
    import {token} from "../stores.js";


    // const handleId = async () => {
    //
    //
    //     const response = await fetch(`http://localhost:8080/api/book/${data}`, {
    //         method: "GET",
    //         headers: {
    //             "Content-Type": "application/json"
    //         },
    //     });
    //     if (response.ok) {
    //         // Erfolgreich erstellt
    //         console.log("Buch wurde erfolgreich gelöscht");
    //     } else {
    //         // Fehler beim Erstellen
    //         console.error('Fehler beim löschen');
    //     }
    // }


    let email = '';
    let password = '';
    let loginId = '';

     async function signIn() {
        const requestData = {
            email:email,
            loginId: loginId,
            password: password
        };

        const res = await fetch('http://localhost:8080/api/auth/signin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'

            },
            credentials: 'include', // CORS-Zugriff ermöglichen
            mode: 'cors',

            body: JSON.stringify(requestData)
        });
        if(res.ok){
            console.log("Einloggen erfolgreich!");
            let json = await res.json();
            token.set(json.token)
            localStorage.setItem('token', json.token);
        }
        else{
            console.log("Einloggen nicht erfolgreich!")
        }

    }

    onMount(() => {
        const storedToken = localStorage.getItem('token');
        console.log(storedToken);
        if (storedToken) {
            token.set(storedToken);
        }
    });

</script>

<svelte:head>
    <title>📕Adventure Bookstore</title>
    <meta name="description" content="Svelte demo app"/>
</svelte:head>

<section>

    <div >
        <img class="left rounded-circle transition-shadow " src={totoro} alt=""/>


        <form on:submit={signIn} class="right">
            <div class="form-outline mb-4 w-50 ">
                <label for="text" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your
                    username</label>
                <input  bind:value={loginId} type="text" id="text"
                       class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                       placeholder="username" required>
            </div>
            <div class="mb-6 w-50">
                <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your
                    password</label>
                <input bind:value={password} type="password" id="password"
                       class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                       required>
            </div>
            <div class="flex items-start mb-6 sm:input-group-sm">
                <div class="flex items-center h-5">
                    <input  id="remember" type="checkbox" value=""
                           class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-blue-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:focus:ring-offset-gray-800">
                </div>
                <label for="remember" class="ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Remember
                    me</label>
            </div>
            <button class=" text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                <a href="http://localhost:5173/register" class="text-white">Register</a>
            </button>

            <button type="submit"
                    class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                Submit
            </button>
        </form>
    </div>
</section>

<style>
    section {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        flex: 0.6;
    }

    .left{
       width: 25%;
        float:left;
    }
    .right{
        width: 50%;
        float:right;
    }

</style>
