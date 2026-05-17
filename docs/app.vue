<script setup lang="ts">
const year = new Date().getFullYear()

const groups = [
  {
    label: 'connect',
    items: [
      'tailscale ssh — magicdns, passwordless',
      'classic ssh — password and key auth',
      'ed25519 + rsa key import & generation',
      'mosh — roaming, low-latency mobile shell',
      'integrated sftp browser — upload, download, delete',
      'biometric lock — app-wide and per-server',
    ],
  },
  {
    label: 'terminal',
    items: [
      'kitty image protocol — inline image rendering',
      '400+ official ghostty themes',
      'configurable accessory key row — reorder, single / multi-row',
      'custom key macros and nested key groups',
      'chuchu key — leader-style prefix for app actions',
      'configurable fonts (jetbrains mono · fira code · hack) + size',
      'real resize, scrollback, focus, mouse and modifier keys',
      'system clipboard copy / paste',
    ],
  },
  {
    label: 'sessions',
    items: [
      'multi-session tabs with command palette switcher',
      'foreground service keeps sessions alive in background',
    ],
  },
  {
    label: 'under the hood',
    items: [
      'native libghostty terminal renderer via jni',
      'native libssh2 + openssl for ssh / sftp',
      'native mosh built in zig',
      'kotlin + jetpack compose ui',
      'room persistence for hosts and keys',
    ],
  },
]
</script>

<template>
  <main class="min-h-screen flex flex-col items-center px-4 py-6 md:py-10">
    <!-- TUI "window" -->
    <div
      class="w-full max-w-3xl border border-line rounded-md bg-bg overflow-hidden flex flex-col"
    >
      <!-- title bar -->
      <div
        class="tui-bar flex items-stretch justify-between border-b border-line text-xs"
      >
        <div class="flex items-stretch">
          <span class="seg bg-magenta text-bg font-bold">NORMAL</span>
          <span class="seg text-fg">chuchu</span>
          <span class="seg text-muted">v0.1.4</span>
        </div>
        <div class="hidden sm:flex items-stretch text-muted">
          <span class="seg">~/chuchu</span>
          <span class="seg bg-line text-fg">main</span>
        </div>
      </div>

      <!-- content -->
      <div class="p-5 md:p-8">
        <!-- hero: text left, demo right -->
        <div class="flex flex-col sm:flex-row sm:items-start gap-6">
          <div class="flex-1 min-w-0">
            <div class="flex items-start gap-3 mb-4">
              <img src="/logo.png" alt="" class="w-9 h-9 rounded mt-0.5" />
              <div>
                <h1 class="text-fg text-base font-bold">chuchu</h1>
                <p class="text-muted text-xs">
                  native android ssh client · powered by libghostty
                </p>
              </div>
            </div>

            <p class="text-fg/90 mb-2">
              <span class="text-magenta">$</span> A modern, native Android SSH
              client with a real terminal renderer.
            </p>
            <p class="text-muted mb-5">
              Tailscale, SSH and Mosh · kitty image protocol · 400+ ghostty
              themes · multi-session tabs · sftp · biometric lock.
            </p>

            <div class="flex flex-wrap gap-1 text-xs">
              <a
                href="https://github.com/jossephus/chuchu/releases/tag/v0.1.4"
                class="seg !no-underline bg-blue text-bg font-bold rounded-sm hover:bg-magenta"
              >
                ↓ download apk
              </a>
              <a
                href="https://github.com/jossephus/chuchu/releases"
                class="seg !no-underline border border-line rounded-sm hover:border-blue !text-fg"
              >
                releases
              </a>
              <a
                href="https://github.com/jossephus/chuchu"
                class="seg !no-underline border border-line rounded-sm hover:border-blue !text-fg"
              >
                github
              </a>
              <a
                href="https://github.com/jossephus/chuchu/issues"
                class="seg !no-underline border border-line rounded-sm hover:border-blue !text-fg"
              >
                issues
              </a>
            </div>
          </div>

          <a
            href="/chuchu_demo.gif"
            class="block shrink-0 w-40 sm:w-48 mx-auto sm:mx-0"
            aria-label="watch demo"
          >
            <img
              src="/chuchu_demo.gif"
              alt="chuchu demo"
              class="w-full rounded-sm border border-line"
            />
          </a>
        </div>

        <!-- features -->
        <template v-for="g in groups" :key="g.label">
          <div class="tui-rule">{{ g.label }}</div>
          <ul class="space-y-1">
            <li v-for="item in g.items" :key="item">
              <span class="text-green">[x]</span> {{ item }}
            </li>
          </ul>
        </template>

        <!-- install -->
        <div class="tui-rule">install</div>
        <p class="mb-3">
          <span class="text-magenta">#</span> users — sideload the apk from
          <a href="https://github.com/jossephus/chuchu/releases">releases</a>.
          no play store yet (payment limits in my country).
        </p>
        <pre class="text-xs bg-bg border border-line rounded-sm p-3 overflow-x-auto"><code><span class="text-muted"># build from source</span>
<span class="text-magenta">$</span> nix develop
<span class="text-magenta">$</span> make build      <span class="text-muted"># zig + jni native</span>
<span class="text-magenta">$</span> make app        <span class="text-muted"># build apk + install</span></code></pre>

        <!-- about -->
        <div class="tui-rule">about</div>
        <p class="mb-2">
          inspired by
          <a href="https://github.com/vivy-company/vvterm">vvterm</a> on iOS —
          chuchu is the android-native version i wanted to exist.
        </p>
        <p class="text-muted">
          <span class="text-gold">chuchu</span> is a character from the Amharic
          novel <em>Yesinbit Kelemat</em> — <em>"colors of adios."</em>
        </p>
      </div>

      <!-- bottom status bar -->
      <div
        class="tui-bar flex items-stretch justify-between border-t border-line text-xs mt-auto"
      >
        <div class="flex items-stretch">
          <span class="seg bg-blue text-bg font-bold">CHUCHU</span>
          <span class="seg text-muted hidden sm:inline-flex">© {{ year }} · MIT</span>
        </div>
        <div class="flex items-stretch text-muted">
          <span class="seg hidden sm:inline-flex">utf-8</span>
          <span class="seg hidden sm:inline-flex">unix</span>
          <span class="seg bg-line text-fg">:q</span>
        </div>
      </div>
    </div>
  </main>
</template>
