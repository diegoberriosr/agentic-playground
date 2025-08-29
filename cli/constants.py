class flags:
    SIMPLE_CHAT_FLAG = '-n'
    SEQUENTIAL_FLAG = '--s'
    LOOP_FLAG = '--l'
    PARALLEL_FLAG = '--p'
    CONDITIONAL_FLAG = '--c'

    def __init__(self):
        raise TypeError("Flag is a constan utils class. You may not instantiate it.")

ROUTE_MAP = {
    flags.SIMPLE_CHAT_FLAG: '/chat',
    flags.SEQUENTIAL_FLAG: '/sequential',
    flags.LOOP_FLAG: '/loop',
    flags.PARALLEL_FLAG:'/parallel',
    flags.CONDITIONAL_FLAG: 'conditional',
}

