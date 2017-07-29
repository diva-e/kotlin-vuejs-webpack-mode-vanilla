<template>
    <div class="monster">
        <img class="monster__image img-rounded" v-if="imageSrc"
             :src="imageSrc">
        <span class="monster__underline" v-if="name"><span class="monster__name">{{name}}</span></span>
    </div>
</template>

<script>
    import kotlinApp from "kotlinApp";

    export default new kotlinApp.com.divae.monster.Monster();
</script>


<style scoped>
    @import "../../../common/bootstrap.css";

    .monster {
        --width: 200px;
        --height: var(--width);
        height: var(--height);
        width: var(--width);
        position: relative;
    }

    .monster__underline {
        font-size: var(--font-size-large);
        background-color: transparent;
        position: absolute;
        top: calc(var(--height) - var(--font-size-large) * var(--line-height-base));
        text-align: right;
        width: 100%;
    }

    .monster__name {
        border: 1px solid rgb(0, 0, 0);
        color: rgb(0, 0, 0);
        background-color: rgb(255, 255, 255);
        padding: 2px;
    }

    .monster__image {
        width: var(--width);
        height: var(--height);
    }
</style>