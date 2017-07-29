<template>
    <div class="battleground">
        <transition name="battleground__episode-name--fade">
            <span class="battleground__episode-name" v-if="episodeName && !monstersArrived"><span
                    class="alert alert-info">{{episodeName}}</span></span>
        </transition>
        <img class="battleground__image" v-if="imageSrc"
             :src="imageSrc">
        <div v-if="monstersArrived" class="battleground__monsters"
             v-bind:class="{ 'battleground__monsters--big': monstersBig, 'battleground__monsters--killed': monstersKilled}">
            <monster-component
                    :name="monsters.name"
                    :image-src="monsters.image"></monster-component>
        </div>
        <div v-if="powerRangersArrived && !megazordArrived" class="battleground__power-rangers">
            <power-ranger-component v-for="(ranger, index) in powerRangers.rangers" :key="index"
                                    v-on:morphed="powerRangerMorphed"
                                    :start-morph="startMorph"
                                    :start-un-morph="startUnMorph"
                                    :name="ranger.name"
                                    :image-src="ranger.normalImage"
                                    :morphing-image-src="ranger.morphingImage"
                                    :morphed-image-src="ranger.morphedImage"></power-ranger-component>
        </div>
        <img class="battleground__megazord-image" v-if="megazordArrived && powerRangers.megaZordImage"
             :src="powerRangers.megaZordImage">
        <span class="battleground__underline" v-if="storyText"><span
                v-bind:class="{ 'alert-danger' : monsterIsSaying, 'alert-success' : powerRangerIsSaying}"
                class="alert">{{storyText}}</span></span>
    </div>
</template>

<script>
    import kotlinApp from "kotlinApp";

    export default new kotlinApp.com.divae.battleground.Battleground();
</script>


<style scoped>
    @import "../power-ranger-component/variables.css";
    .battleground {
        position: relative;
    }

    .battleground__underline {
        font-size: var(--font-size-large);
        position: absolute;
        top: calc(100vh - var(--font-size-large) * var(--line-height-base) - var(--alert-padding));
        text-align: center;
        width: 100%;
    }

    .battleground__episode-name {
        font-size: 20px;
        position: absolute;
        top: 50px;
        text-align: center;
        width: 100%;
    }

    .battleground__image {
        width: 100vw;
        height: 100vh;
    }

    .battleground .battleground__power-rangers {
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
        position: absolute;
        top: calc(100vh / 2 - var(--power-ranger--height));
        right: 10vh;
        width: calc(var(--power-ranger--width) * 3 + var(--power-ranger--margin) * 6);
    }

    .battleground .battleground__megazord-image {
        height: calc(var(--power-ranger--height) * 3);
        width: calc(var(--power-ranger--width) * 3);
        position: absolute;
        right: 10vh;
        top: calc((100vh - var(--power-ranger--width) * 3) / 2);
    }

    .battleground .battleground__monsters {
        --monster-height: 200px;
        --monster-width: 200px;
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
        position: absolute;
        top: calc(100vh / 2 - var(--monster-height) * 0.5);
        left: 20vh;
    }

    .battleground .battleground__monsters.battleground__monsters--big {
        transform: scale(2.5, 2.5);
    }

    .battleground .battleground__monsters.battleground__monsters--killed {
        transform: rotate(180deg);
    }

    .battleground .battleground__monsters.battleground__monsters--big.battleground__monsters--killed {
        transform: scale(2.5, 2.5) rotate(180deg);
    }

    .battleground__episode-name--fade-enter-active, .battleground__episode-name--fade-leave-active {
        transition: opacity 0.5s
    }

    .battleground__episode-name--fade-enter, .battleground__episode-name--fade-leave-to {
        opacity: 0
    }
</style>