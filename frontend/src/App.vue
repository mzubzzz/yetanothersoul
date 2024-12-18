<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import HeaderPart from './components/HeaderPart.vue'
</script>

<template>
  <header>

    <div class="wrapper">
      <HeaderPart msg="YET ANOTHER SOUL" />

      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
</style>
