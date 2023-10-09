<script lang="ts">

    import {onMount} from "svelte";


    let data = {
        categories: [],
    }

    let booktitle = '';
    let pages = '';
    let price = '';
    let releaseDate = '';
    let bookEntry = '';
    let selectedCategoryId = '';
    let stock='';


    async function fetchCategories() {
        try {
            const response = await fetch('http://localhost:8080/api/category/all');
            if (response.ok) {
                data.categories = await response.json();
            } else {
                console.error("Fehler beim Abrufen der Kategorien")
            }
        } catch (error) {
            console.error("Fehler beim Abrufen der Kategorien", error)
        }
    }

    fetchCategories();

    async function handler() {
        const formData = {
            booktitle,
            pages,
            price,
            releaseDate,
            bookEntry,
            idcategory: selectedCategoryId,
            stock,

        };


        const response = await fetch('http://localhost:8080/api/book/create', {
            method: 'POST',
            headers: {
                "Content-Type": 'application/json'
            },
            body: JSON.stringify(formData)
        });
        if (response.ok) {
            console.log('Buch wurde erstellt');
        } else {
            console.error('Fehler beim Erstellen');
        }
    }

</script>


<main>
    <form on:submit={handler}>
        <div class="flex">
            <div class="container text-black -mb-20 flex-col flex-1 w-full">
                <label>Title:</label>
                <div>
                    <input bind:value={booktitle} type="text" id="booktitle"
                           class="input input-bordered w-full max-w-xs bg-blue-200"/>
                </div>
                <label>Pages:</label>
                <div>
                    <input bind:value={pages} name="pages" id="pages" type="text"
                           class="input input-bordered w-full max-w-xs bg-blue-200"/>
                </div>
                <label>Price:</label>
                <div>
                    <input bind:value={price} name="price" id="price" type="text"
                           class="input input-bordered w-full max-w-xs bg-blue-200"/>
                </div>
                <label>Release:</label>
                <div>
                    <input bind:value={releaseDate} id="releaseDate" name="releaseDate" type="date"
                           class="input input-bordered w-full max-w-xs bg-blue-200"/>
                </div>

                <label for="stock">Exemplare:</label>
                <div>
                    <input bind:value={stock} class="input input-bordered w-full max-w-xs bg-blue-200"/>
                </div>

                <label for="category">Kategorie:</label>
                <div class="w-25">
                    <select id="category" name="category" bind:value={selectedCategoryId} class="form-select">
                        <option>Wähle Kategorie</option>
                        {#each data.categories as category}
                            <option value={category.idcategory}>{category.categoryname}</option>
                        {/each}
                    </select>
                </div>

                <div class="container d-flex justify-content-end ">
                    <div class="row align-items-center ">
                        <div class="col">
                            <button class="btn btn-success" type="submit">Create a Book</button>
                        </div>
                        <div class="col">
                            <button class="btn btn-error" type="reset">Reset</button>
                        </div>
                        <div></div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</main>
<style>


</style>

<!--<div>
    <input bind:value={bookEntry} type="file" class="file-input file-input-bordered w-full max-w-xs"/>
</div>-->


<!--<div class="form-group form-check-input btn mt-3 ml-1.5 w-15" >
                <select id="category" bind:value={selectedCategory} class="form-select">
                    <option value="">Kategorie</option>
                    {#each data.categories as category}
                        <option value={category.idcategory}>{category.categoryname}</option>
                    {/each}
                </select>
            </div>
            </div>-->

<!--  <div class="flex w-64">
      <div>
          <textarea bind:value={bookEntry} class="justify textarea textarea-bordered bg-blue-200"
                    name="bookEntry" rows="10" cols="50"></textarea>
      </div>
  </div>-->