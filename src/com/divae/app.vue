<template>
    <div class="app">
        <button v-if="!battlegroundIsReady" class="app__generate-button btn btn-danger btn-lg" v-on:click="generate"
                type="button">Generate Episode
        </button>

        <battleground-component v-if="battlegroundIsReady"
                                :image-src="battelgroundImageSrc"
                                :power-rangers="powerRangers"
                                :monsters="monsters"
                                :episode-name="episodeName"></battleground-component>
    </div>
</template>

<script>
    import kotlinApp from "kotlinApp";

    export default new kotlinApp.com.divae.App();
</script>
<style scoped>
    @import "~bootstrap/dist/css/bootstrap.css";

    .app {
        background-color: rgb(0, 0, 0);
        width: 100vw;
        height: 100vh;
        position: relative;
        padding-top: 10vh;
    }

    .app .app__generate-button {
        margin-left: auto;
        margin-right: auto;
        display: block;
        margin-top: 20vh;
    }
</style>