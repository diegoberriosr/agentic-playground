class flags:
    SIMPLE_CHAT_FLAG = '-n'
    SEQUENTIAL_FLAG = '--s'
    LOOP_FLAG = '--l'
    PARALLEL_FLAG = '--p'
    CONDITIONAL_FLAG = '--c'
    D_PARALLEL_FLAG = "--dp"
    D_CONDITIONAL_FLAG = "--dc"
    CONTEXTUAL_FLAG = "--ctx"
    PURE_AGENTIC = "--pa"

    def __init__(self):
        raise TypeError("Flag is a constan utils class. You may not instantiate it.")

ROUTE_MAP = {
    flags.SIMPLE_CHAT_FLAG: '/chat',
    flags.SEQUENTIAL_FLAG: '/sequential',
    flags.LOOP_FLAG: '/loop',
    flags.PARALLEL_FLAG:'/parallel',
    flags.CONDITIONAL_FLAG: '/conditional',
    flags.D_PARALLEL_FLAG: '/declarative/parallel',
    flags.D_CONDITIONAL_FLAG: '/declarative/conditional',
    flags.CONTEXTUAL_FLAG: "/contextual",
    flags.PURE_AGENTIC: "/pure-agentic",
}

