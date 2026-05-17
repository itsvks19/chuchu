/** @type {import('tailwindcss').Config} */
export default {
  darkMode: 'class',
  content: [
    './pages/**/*.vue',
    './app.vue',
    './nuxt.config.{js,ts}',
  ],
  theme: {
    extend: {
      fontFamily: {
        mono: ['"JetBrains Mono"', 'ui-monospace', 'SFMono-Regular', 'Menlo', 'monospace'],
      },
      colors: {
        bg: '#1a1b26',
        fg: '#c0caf5',
        muted: '#565f89',
        line: '#2a2e44',
        magenta: '#bb9af7',
        blue: '#7aa2f7',
        gold: '#e0af68',
        green: '#9ece6a',
      },
    },
  },
  plugins: [],
}
