// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  compatibilityDate: '2025-01-01',
  ssr: true,
  devtools: { enabled: false },
  modules: ['@nuxtjs/tailwindcss'],
  css: ['~/assets/css/main.css'],
  nitro: {
    preset: 'static',
  },
  app: {
    // GitHub Pages serves the site at /chuchu/ — adjust if hosting from root.
    baseURL: process.env.NUXT_APP_BASE_URL || '/',
    head: {
      title: 'Chuchu — Native Android SSH client',
      htmlAttrs: { lang: 'en', class: 'dark' },
      bodyAttrs: { class: 'antialiased' },
      meta: [
        { charset: 'utf-8' },
        { name: 'viewport', content: 'width=device-width, initial-scale=1' },
        {
          name: 'description',
          content:
            'Chuchu is a modern, native Android SSH client powered by libghostty. Tailscale + SSH, kitty image protocol, 400+ themes.',
        },
        { name: 'theme-color', content: '#1a1b26' },
        { property: 'og:title', content: 'Chuchu — Native Android SSH client' },
        {
          property: 'og:description',
          content:
            'A modern, native Android SSH client powered by libghostty. Tailscale + SSH, kitty image protocol, 400+ themes.',
        },
        { property: 'og:type', content: 'website' },
        { property: 'og:image', content: '/logo.png' },
      ],
      link: [
        { rel: 'icon', type: 'image/png', href: '/logo.png' },
        {
          rel: 'preconnect',
          href: 'https://fonts.googleapis.com',
        },
        {
          rel: 'preconnect',
          href: 'https://fonts.gstatic.com',
          crossorigin: '',
        },
        {
          rel: 'stylesheet',
          href: 'https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@400;500;700&family=Inter:wght@400;500;600;700&display=swap',
        },
      ],
    },
  },
})
