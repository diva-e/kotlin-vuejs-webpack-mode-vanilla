<template>
    <div class="power-ranger">
        <img class="power-ranger__un-morphed-image img-circle" v-if="!isMorphed && !isMorphing && imageSrc"
             :src="imageSrc">
        <img class="power-ranger__morphing-image img-circle" v-if="isMorphing && morphingImageSrc"
             :src="morphingImageSrc">
        <img class="power-ranger__morphed-image img-circle" v-if="isMorphed && morphedImageSrc"
             :src="morphedImageSrc">
        <span class="power-ranger__underline img-circle" v-if="name"><span
                class="power-ranger__name">{{name}}</span></span>
    </div>
</template>

<script>
    import kotlinApp from "kotlinApp";

    export default new kotlinApp.com.divae.powerranger.PowerRanger();
</script>


<style scoped>
    @import "../../../common/bootstrap.css";
    @import "./variables.css";

    .power-ranger {
        height: var(--power-ranger--height);
        width: var(--power-ranger--width);
        position: relative;
        margin: var(--power-ranger--margin);
    }

    .power-ranger__underline {
        font-size: var(--font-size-large);
        background-color: transparent;
        position: absolute;
        top: calc(var(--power-ranger--height) - var(--font-size-large) * var(--line-height-base));
        text-align: right;
        width: 100%;
    }

    .power-ranger__name {
        border: 1px solid rgb(0, 0, 0);
        color: rgb(0, 0, 0);
        background-color: rgb(255, 255, 255);
        padding: 2px;
    }

    .power-ranger__un-morphed-image, .power-ranger__morphing-image, .power-ranger__morphed-image {
        width: var(--power-ranger--width);
        height: var(--power-ranger--height);
    }
</style>