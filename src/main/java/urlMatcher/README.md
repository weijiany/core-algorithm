# URL 匹配器

使用前缀树进行 URL 匹配器

根据 Resource 定义，

当传入这样的 URL： /clubs/{clubId}/persons/{personId} 会输出两个 Id

当传入的是没有在 TrieTree 中定义的 URL，会返回 null
