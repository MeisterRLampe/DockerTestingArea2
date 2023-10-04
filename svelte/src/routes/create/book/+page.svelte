<script>

    let booktitle = '';
    let pages = '';
    let price = "";
    let releaseDate = "";
    let bookEntry = "";
    let category ='';

    const handler = async () => {
        const formData = {
            booktitle,
            pages,
            price,
            category,
            releaseDate,
            bookEntry
        };
        const response = await fetch('http://localhost:8080/api/book/create', {
            method: 'POST',
            headers: {
                "Content-Type": 'application/json'
            },
            body: JSON.stringify(formData)
        });
        if (response.ok) {
            // Erfolgreich erstellt
            console.log('Buch wurde erstellt');
        } else {
            // Fehler beim Erstellen
            console.error('Fehler beim erstellen');
        }

    }


</script>


<main>
    <form on:submit={handler}>
        <div class="flex">
            <div class="container text-black -mb-20  flex-col flex-1 w-64">
                <label>Title:</label>
                <div><input bind:value={booktitle} type="text" class="input input-bordered w-full max-w-xs bg-blue-200">
                </div>
                <label>Pages:</label>
                <div><input bind:value={pages} name="pages" type="text"
                            class="input input-bordered w-full max-w-xs bg-blue-200"/></div>
                <label>Price:</label>
                <div><input bind:value={price} name="price" type="text"
                            class="input input-bordered w-full max-w-xs bg-blue-200"/></div>
                <label>Release:</label>
                <div><input bind:value={releaseDate} name="releaseDate" type="date"
                            class="input input-bordered w-full max-w-xs bg-blue-200"/></div>
                <label>Category:</label>
                <div><input bind:value={category} name="price" type="text"
                            class="input input-bordered w-full max-w-xs bg-blue-200"/></div>

            </div>
            <div class="flex 1 w-64 mr-40 mt-20">
                <div><textarea bind:value={bookEntry} class="justify textarea textarea-bordered bg-blue-200" name="bookEntry"
                               rows="10"
                               cols="50"></textarea></div>

            </div>
        </div>
        <div class="container grid grid-cols-5 gap-3.5">
            <div>
                <button class="btn btn-success" type="submit">Create a Book</button>
            </div>
            <div >
                <button class=" btn btn-error" type="reset">Reset</button>
            </div>
            <div></div>
            <div>
                <input bind:value={bookEntry} type="file" class="file-input file-input-bordered w-full max-w-xs"/>
            </div>
        </div>


    </form>
</main>


<style>
    textarea {
        resize: none;
    }
</style>

<!-- class="btn mt-10 ml-80"
 class="btn -mr-20"
 class="mb-10"
 -->